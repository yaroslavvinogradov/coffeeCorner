package iv.receipt;

public class ReceiptPrinterImpl implements ReceiptPrinter {
    @Override
    public void printLine(String line) {
        System.out.println(line);
    }
}
