/**
 * 
 */
package com.ihome.matrix.cluster.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.cluster.CategoryCluster;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ItemDO;

/**
 * 简单的关键字匹配Item类目聚类器
 * @author sihai
 *
 */
public class SimpleCategoryCluster implements CategoryCluster {
	
	private static final Log logger = LogFactory.getLog(SimpleCategoryCluster.class);
	
	private CategoryDO root;
	private List<CategoryInfoHolder> categoryList;
	// TODO change to LRU
	private BoundedConcurrentHashMap<ItemInfoHolder, CategoryInfoHolder> cache;		// 
	
	/**
	 * 
	 * @param root 类目树
	 */
	public void init(CategoryDO root) {
		this.root = root;
		if(null != root) {
			cache = new BoundedConcurrentHashMap<ItemInfoHolder, CategoryInfoHolder>();
			categoryList = new ArrayList<CategoryInfoHolder>(8192);
			_build_metadata_();
		} else {
			categoryList = Collections.EMPTY_LIST;
		}
	}
	
	@Override
	public CategoryDO clusterCategory(ItemDO item) {
		return _cluster_(newItemInfoHolderInstance(item));
	}
	
	private void _build_metadata_() {
		_build_metadata_(root);
	}
	
	private void _build_metadata_(CategoryDO category) {
		if(null != category.getChildren() && !category.getChildren().isEmpty()) {
			for(CategoryDO child : category.getChildren()) {
				_build_metadata_(child);
			}
		} else {
			categoryList.add(newCategoryInfoHolderInstance(category));
		}
	}
	
	private CategoryDO _cluster_(ItemInfoHolder itemInfo) {
		CategoryInfoHolder result = cache.get(itemInfo);
		if(null != result) {
			return result.category;
		} else {
			result = _match_(itemInfo);
			if(null != result) {
				// cached
				cache.put(itemInfo, result);
			}
			return result.category;
		}
	}
	
	private CategoryInfoHolder _match_(ItemInfoHolder itemInfo) {
		CategoryInfoHolder current = null;
		int max = Integer.MIN_VALUE;
		int hit = 0;
		for(CategoryInfoHolder c : categoryList) {
			hit = _hit_(c, itemInfo);
			if(hit > max) {
				max = hit;
				current = c;
			}
		}
		
		return current;
	}
	
	private int _hit_(CategoryInfoHolder c, ItemInfoHolder itemInfo) {
		int result = 0;
		for(String keyword : c.keywords) {
			if(itemInfo.name.contains(keyword)) {
				result++;
			}
		}
		return result;
	}
	
	private ItemInfoHolder newItemInfoHolderInstance(ItemDO item) {
		return new ItemInfoHolder(item);
	}
	
	private CategoryInfoHolder newCategoryInfoHolderInstance(CategoryDO category) {
		return new CategoryInfoHolder(category);
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	private class ItemInfoHolder {
		
		String name;			// 目前只用到 name
		
		public ItemInfoHolder(ItemDO item) {
			this.name = item.getName();
		}
		
		@Override
		public int hashCode() {
			return name.hashCode();
		}
		
		@Override
		public boolean equals(Object o) {
			if(null == o) {
				return false;
			}
			if(!(o instanceof ItemInfoHolder)) {
				return false;
			}
			if(null == name || null == ((ItemInfoHolder)o).name) {
				return false;
			}
			return name.equals(((ItemInfoHolder)o).name);
		}
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	private class CategoryInfoHolder {
		
		CategoryDO category;
		List<String> keywords;
		
		public CategoryInfoHolder(CategoryDO category) {
			this.category = category;
			if(StringUtil.isBlank(category.getKeywords())) {
				keywords = Collections.EMPTY_LIST;
			} else {
				keywords = new ArrayList<String>();
				String[] array = category.getKeywords().split(",");
				for(String s : array) {
					if(StringUtil.isNotBlank(s)) {
						keywords.add(s.trim());
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 * @param <K>
	 * @param <V>
	 */
	public class BoundedConcurrentHashMap<K, V> extends LinkedHashMap<K, V> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2012539068375667054L;

		private static final int DEFAULT_CAPACITY = 389; 

		private int capacity;

		private final Lock lock = new ReentrantLock();
//		private final Lock readLock = lock.readLock();
//		private final Lock writeLock = lock.writeLock();

		public BoundedConcurrentHashMap(int capacity) {
			super(capacity * 4  / 3 + 1, 0.75f, true); //优化：乘以4/3以避免resize()
			this.capacity = capacity;
		}

		public BoundedConcurrentHashMap() {
			this(DEFAULT_CAPACITY);
		}

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {;
			boolean ret = size() > capacity;
			if(logger.isDebugEnabled()) {
				if(ret) {
					logger.debug("removeEldestEntry size: "+size()+", capacity: "+capacity);
				}
			}
			return ret;
		}

		@Override
		public void clear() {
			lock.lock();
			try {
				super.clear();
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public Object clone() {
			lock.lock();
			try {
				return super.clone();
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public boolean equals(Object o) {
			lock.lock();
			try {
				return super.equals(o);
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public int hashCode() {
			lock.lock();
			try {
				return super.hashCode();
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public String toString() {
			lock.lock();
			try {
				return super.toString();
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public boolean containsValue(Object value) {
			lock.lock();
			try {
				return super.containsValue(value);
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public V get(Object key) {
			lock.lock();
			try {
				return super.get(key);
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public boolean containsKey(Object key) {
			lock.lock();
			try {
				return super.containsKey(key);
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public Set<java.util.Map.Entry<K, V>> entrySet() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isEmpty() {
			lock.lock();
			try {
				return super.isEmpty();
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public Set<K> keySet() {
			throw new UnsupportedOperationException();
		}

		@Override
		public V put(K key, V value) {
			lock.lock();
			try {
				return super.put(key, value);
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public void putAll(Map<? extends K, ? extends V> m) {
			lock.lock();
			try {
				super.putAll(m);
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public V remove(Object key) {
			lock.lock();
			try {
				return super.remove(key);
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public int size() {
			lock.lock();
			try {
				return super.size();
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public Collection<V> values() {
			throw new UnsupportedOperationException();
		}
	}
}