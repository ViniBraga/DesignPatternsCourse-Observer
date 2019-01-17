
public class ActionTest {

	public static void main(String[] args) {

		BillOfSaleBuilder bsBuilder = new BillOfSaleBuilder();
		
		bsBuilder.includeActionOnGenerating(new SmsSender());
		bsBuilder.includeActionOnGenerating(new EmailSender());
		bsBuilder.includeActionOnGenerating(new Printer());
		bsBuilder.includeActionOnGenerating(new BillOfSaleDao());
		
		bsBuilder.toCompany("Google")
			.includeCnpj("11.123.456/0001-01")
			.includeItem(new BillItem("Item 1", 100.0))
			.includePs("Any ps")
			.inCurrentDate();
		
		BillOfSale bs = bsBuilder.build();
		System.out.println(bs.getGrossValue());
		
	}

}
