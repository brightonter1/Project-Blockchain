import java.util.Date;
import java.util.List;

public class BlockChain {
    private String Data;
    private String previosHash;
    private String currentHash;

    public BlockChain(String data, String previosHash, String currentHash) {
        Data = data;
        this.previosHash = previosHash;
        this.currentHash = currentHash;
    }

    @Override
    public String toString() {
        return "--------------------------------------------\n" +
                "PREVIOS HASH : " + previosHash +"\n" +
                "DATA : " + Data + "\n" +
                "CURRENT HASH : " + currentHash +"\n" +
                "--------------------------------------------\n";
    }

    public BlockChain() {
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getPreviosHash() {
        return previosHash;
    }

    public void setPreviosHash(String previosHash) {
        this.previosHash = previosHash;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public void setCurrentHash(String currentHash) {
        this.currentHash = currentHash;
    }
}
