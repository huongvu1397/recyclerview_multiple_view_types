# recyclerview_multiple_view_types

<img src="Screenshot_20190426-100409_MultipleRCVDemo.jpg" width="350" height="350" alt="Demo"/>

Một Recyclerview với nhiều type 

```
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
