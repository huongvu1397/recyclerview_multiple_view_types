# recyclerview_multiple_view_types

<img src="Screenshot_20190426-100409_MultipleRCVDemo.jpg" width="400" height="400" alt="Demo"/>

Một Recyclerview với nhiều type với dữ liệu fake
  Cài đặt thuộc tính cho RecyclerView
```kotlin
 var grid = GridLayoutManager(this, 4)
        rcl_view.apply {
            adapter = this@MainActivity.adapter
            grid.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    var type = adapter?.getItemViewType(position)
                    return if (type == 0) {
                        4
                    } else {
                        1
                    }
                }

            }
            rcl_view.layoutManager = grid
            ...
        }
```

  Bên Adapter
```kotlin
   override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        if (type == TYPE_FOOTER) {
            return FooterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.footer_view, parent, false))
        } else {
            return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 20) {  // set vị trí cuối cùng của list
            TYPE_FOOTER
        } else {
            TYPE_ITEM
        }
    }
    
      override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (viewHolder is MainViewHolder) {
            ...
            ...
        }
    }
```    
    
