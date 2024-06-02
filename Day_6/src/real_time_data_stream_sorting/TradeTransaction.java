package real_time_data_stream_sorting;

public class TradeTransaction  implements Comparable<TradeTransaction> {
		double price;
		public TradeTransaction(double price) {
			this.price = price;
		}
		
		@Override
		public int compareTo(TradeTransaction other) {
			return Double.compare(this.price, other.price);
		}
	}
