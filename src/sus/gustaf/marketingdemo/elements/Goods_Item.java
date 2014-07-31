package sus.gustaf.marketingdemo.elements;

public class Goods_Item{
	public int goods_photo_id;
	public String goods_content;
	public String goods_name;
	public int goods_price;
	public Goods_Item(int id, String n, String content, int pri) {
		goods_photo_id = id;
		goods_name = n;
		goods_price = pri;
		this.goods_content = content;
	}
}
