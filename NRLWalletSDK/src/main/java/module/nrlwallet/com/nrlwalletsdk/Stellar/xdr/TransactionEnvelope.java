// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package module.nrlwallet.com.nrlwalletsdk.Stellar.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct TransactionEnvelope
//  {
//      Transaction tx;
//      /* Each decorated signature is a signature over the SHA256 hash of
//       * a TransactionSignaturePayload */
//      DecoratedSignature
//      signatures<20>;
//  };

//  ===========================================================================
public class TransactionEnvelope  {
  public TransactionEnvelope () {}
  private Transaction tx;
  public Transaction getTx() {
    return this.tx;
  }
  public void setTx(Transaction value) {
    this.tx = value;
  }
  private DecoratedSignature[] signatures;
  public DecoratedSignature[] getSignatures() {
    return this.signatures;
  }
  public void setSignatures(DecoratedSignature[] value) {
    this.signatures = value;
  }
  public static void encode(XdrDataOutputStream stream, TransactionEnvelope encodedTransactionEnvelope) throws IOException{
    Transaction.encode(stream, encodedTransactionEnvelope.tx);
    int signaturessize = encodedTransactionEnvelope.getSignatures().length;
    stream.writeInt(signaturessize);
    for (int i = 0; i < signaturessize; i++) {
      DecoratedSignature.encode(stream, encodedTransactionEnvelope.signatures[i]);
    }
  }
  public static TransactionEnvelope decode(XdrDataInputStream stream) throws IOException {
    TransactionEnvelope decodedTransactionEnvelope = new TransactionEnvelope();
    decodedTransactionEnvelope.tx = Transaction.decode(stream);
    int signaturessize = stream.readInt();
    decodedTransactionEnvelope.signatures = new DecoratedSignature[signaturessize];
    for (int i = 0; i < signaturessize; i++) {
      decodedTransactionEnvelope.signatures[i] = DecoratedSignature.decode(stream);
    }
    return decodedTransactionEnvelope;
  }
}
