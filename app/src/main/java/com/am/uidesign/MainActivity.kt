package com.am.uidesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.am.uidesign.adapter.*
import com.am.uidesign.vo.ByRatesVO
import com.am.uidesign.vo.ByRoomVO
import com.am.uidesign.vo.ListItemVO
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.mig35.carousellayoutmanager.CenterScrollListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mListAdapter : ListAdapter
    private lateinit var mTODoListAdapter : ToDoListAdapter
    private lateinit var byRoomAdapter : ByRoomListAdapter
    private lateinit var byRatesAdapter : ByRatesListAdapter
    private lateinit var listData: ArrayList<String>
    private lateinit var toDoListData: ArrayList<ListItemVO>
    private lateinit var byRoomList: ArrayList<ByRoomVO>
    private lateinit var byRatesList: ArrayList<ByRatesVO>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setUpListAdapter()
        setUpToDoListAdapter()
        setUpByRoomAdapter()
        listener()
    }

    private fun init() {
        toDoListData = ArrayList()
        listData = ArrayList()
        byRoomList = ArrayList()
        byRatesList = ArrayList()
    }

    private fun setUpListAdapter() {
        mListAdapter = ListAdapter(this)
        rv_list.layoutManager = CenterZoomLayoutManager(this, CenterZoomLayoutManager.HORIZONTAL,false)
        rv_list.adapter = mListAdapter
        rv_list.scrollToPosition(2)
        rv_list.isScrollbarFadingEnabled = true

//        val layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)
//        layoutManager.setPostLayoutListener(CarouselZoomPostLayoutListener())
//        rv_list.layoutManager = layoutManager
//        rv_list.adapter = mListAdapter
//
//        rv_list.setHasFixedSize(true)
//        rv_list.addOnScrollListener(CenterScrollListener())

        listData.add("")
        listData.add("")
        listData.add("")
        listData.add("")
        mListAdapter.setData(listData)
    }

    private fun setUpToDoListAdapter() {
        mTODoListAdapter = ToDoListAdapter(this)
        rv_toDoList.layoutManager = GridLayoutManager(this, 5)
        rv_toDoList.adapter = mTODoListAdapter
        toDoListData.add(ListItemVO(R.drawable.theme,"Amenities"))
        toDoListData.add(ListItemVO(R.drawable.workout,"Facilities"))
        toDoListData.add(ListItemVO(R.drawable.fnb,"F&B"))
        toDoListData.add(ListItemVO(R.drawable.kidsfamily,"Kids/family"))
        toDoListData.add(ListItemVO(R.drawable.wellness,"Wellness"))
        mTODoListAdapter.setData(toDoListData)
    }

    private fun setUpByRoomAdapter() {
        byRoomAdapter = ByRoomListAdapter(this)
        rv_room_rate.layoutManager = LinearLayoutManager(this)
        rv_room_rate.adapter = byRoomAdapter
        byRoomList.add(ByRoomVO(R.drawable.beach_view,"Deluxe Twin","Twin Single Beds, Cable TV, Free Wifi ...",161.42))
        byRoomList.add(ByRoomVO(R.drawable.beach_view,"Deluxe Twin","Twin Single Beds, Cable TV, Free Wifi ...",161.42))
        byRoomList.add(ByRoomVO(R.drawable.beach_view,"Deluxe Twin","Twin Single Beds, Cable TV, Free Wifi ...",161.42))
        byRoomList.add(ByRoomVO(R.drawable.beach_view,"Deluxe Twin","Twin Single Beds, Cable TV, Free Wifi ...",161.42))
        byRoomAdapter.setData(byRoomList)
    }

    private fun setUpByRateAdapter() {
        byRatesAdapter = ByRatesListAdapter(this)
        rv_room_rate.layoutManager = LinearLayoutManager(this)
        rv_room_rate.adapter = byRatesAdapter
        byRatesList.add(ByRatesVO("YOUR E-VOUCHER RATE","Mobile App Special Voucher","20% off \n In-Room Service",161.42))
        byRatesList.add(ByRatesVO("","Mobile App Special Voucher","20% off \n In-Room Service",161.42))
        byRatesList.add(ByRatesVO("YOUR E-VOUCHER RATE","Mobile App Special Voucher","20% off \n In-Room Service",161.42))
        byRatesList.add(ByRatesVO("YOUR E-VOUCHER RATE","Mobile App Special Voucher","20% off \n In-Room Service",161.42))
        byRatesAdapter.setData(byRatesList)
    }

    private fun listener() {
        tv_byRoom.setOnClickListener {
            ll_group.setBackgroundResource(R.drawable.g2)
            byRoomList = ArrayList()
            setUpByRoomAdapter()
        }

        tv_byRates.setOnClickListener {
            ll_group.setBackgroundResource(R.drawable.g1)
            byRatesList = ArrayList()
            setUpByRateAdapter()
        }
    }

}