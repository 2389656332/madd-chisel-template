package prefetcher

import chisel3._
import chisel3.util._

// TODO: update this module to implement stride prefetcher's IO.
class StridePrefetcherIO(addressWidth: Int, pcWidth: Int) extends Bundle {
    
    // 输入端口
    val pc = Input(UInt(pcWidth.W))
    val address = Input(UInt(addressWidth.W))
    
    // 输出端口
    val prefetch_address = Output(UInt(addressWidth.W))
    val prefetch_valid = Output(Bool())
  }
