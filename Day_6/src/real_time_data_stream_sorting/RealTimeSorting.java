package real_time_data_stream_sorting;

import java.util.PriorityQueue;

public class RealTimeSorting {
	private PriorityQueue<TradeTransaction> minHeap;
	
	public RealTimeSorting() {
		minHeap = new PriorityQueue<>();
	}
	
	public void addTrade(TradeTransaction trade) {
		minHeap.add(trade);
	}
	
	public TradeTransaction getNextTrade() {
		return minHeap.poll();
	}
	
	public static void main(String[] args) {
		RealTimeSorting sorting = new RealTimeSorting();
		
		sorting.addTrade(new TradeTransaction(100.5));
		sorting.addTrade(new TradeTransaction(50.2));
		sorting.addTrade(new TradeTransaction(75.8));
		
		while (true) {
			TradeTransaction trade = sorting.getNextTrade();
			if (trade == null)
				break;
			System.out.println("Next trade price: " + trade.price);
		}
	}
}
