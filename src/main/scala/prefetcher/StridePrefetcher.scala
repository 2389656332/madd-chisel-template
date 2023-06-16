package prefetcher

import chisel3._
import chisel3.util._

// TODO: update this module to implement stride prefetching.
class StridePrefetcher(val addressWidth: Int, val pcWidth: Int) extends Module 
{
  val prev_stride:Int = 100

  class Entry
    def __init__(self: pc, prev_address: prev_stride)
        self.pc = pc
        self.prev_address = prev_address
        self.prev_stride = prev_stride

  val io = IO(new Bundle {
    // 输入端口
    val pc = Input(UInt(pcWidth.W))
    val address = Input(UInt(addressWidth.W))
    // 输出端口
    val prefetch_address = Output(UInt(addressWidth.W))
    val prefetch_valid = Output(Bool())
  })

// 实现Stride Prefetcher的逻辑，例如查找表格、步幅计算和预取地址生成等
  class LookupTable
    // 构造函数
    def __init__(self: capacity)
        var self.entries = Vec(capacity, SInt(32.W))
        var self.capacity = capacity
        var n:Int = 0

    //查找给定PC的条目
    def find(self: pc)
        for (i <- 0 to n)
            if (entry(i).pc == pc)
                return i
        return None  //如果没有找到，返回None

    //插入新条目
    def insert(self: pc)
        //如果表已满，先删除最旧的条目
        if (n >= self.capacity)
            self.entries.pop(0)

        //插入新条目
        new_entry = Entry(pc, address, 0)
        self.entries.append(new_entry)
        n++

// StridePrefetcher 类定义
  class StridePrefetcher
    // 构造函数
    def __init__(self: address_width, pc_width:Int)
        self.address_width = address_width
        self.pc_width = pc_width
        self.table = LookupTable()

    // 处理当前访问的地址和程序计数器
    def process_address(self: address, pc:UInt)
        // 查找当前PC在查找表中的条目
        entry = self.table.find(pc)

        // 如果条目存在，计算步幅
        if (entry != None)
            stride = address - entry.prev_address
            entry.prev_address = address

            // 如果步幅与上一次相同，则生成预取地址并预取
            if (stride == entry.prev_stride)
                prefetch_address = address + stride
                self.prefetch(prefetch_address)

            // 更新步幅
            entry.prev_stride = stride
        if(entry == None)
            // 如果条目不存在，创建一个新条目并存储当前地址和PC
            self.table.insert(pc, address)

    // 预取数据
    def prefetch(self: address)
        // 在这里实现预取数据的逻辑，例如将地址发送到内存控制器
        pass

  // 是否预取的逻辑
  io.prefetch_valid := ture // ...
}
