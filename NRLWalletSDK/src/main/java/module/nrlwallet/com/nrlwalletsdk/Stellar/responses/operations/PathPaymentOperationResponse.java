package module.nrlwallet.com.nrlwalletsdk.Stellar.responses.operations;

import com.google.gson.annotations.SerializedName;

import module.nrlwallet.com.nrlwalletsdk.Stellar.Asset;
import module.nrlwallet.com.nrlwalletsdk.Stellar.AssetTypeNative;
import module.nrlwallet.com.nrlwalletsdk.Stellar.KeyPair;

import module.nrlwallet.com.nrlwalletsdk.Stellar.Asset;
import module.nrlwallet.com.nrlwalletsdk.Stellar.AssetTypeNative;
import module.nrlwallet.com.nrlwalletsdk.Stellar.KeyPair;
import module.nrlwallet.com.nrlwalletsdk.Stellar.Server;
import module.nrlwallet.com.nrlwalletsdk.Stellar.requests.OperationsRequestBuilder;

/**
 * Represents PathPayment operation response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class PathPaymentOperationResponse extends OperationResponse {
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("source_max")
  protected final String sourceMax;
  @SerializedName("from")
  protected final KeyPair from;
  @SerializedName("to")
  protected final KeyPair to;

  @SerializedName("asset_type")
  protected final String assetType;
  @SerializedName("asset_code")
  protected final String assetCode;
  @SerializedName("asset_issuer")
  protected final String assetIssuer;

  @SerializedName("source_asset_type")
  protected final String sourceAssetType;
  @SerializedName("source_asset_code")
  protected final String sourceAssetCode;
  @SerializedName("source_asset_issuer")
  protected final String sourceAssetIssuer;

  public PathPaymentOperationResponse(String amount, String sourceMax, KeyPair from, KeyPair to, String assetType, String assetCode, String assetIssuer, String sourceAssetType, String sourceAssetCode, String sourceAssetIssuer) {
    this.amount = amount;
    this.sourceMax = sourceMax;
    this.from = from;
    this.to = to;
    this.assetType = assetType;
    this.assetCode = assetCode;
    this.assetIssuer = assetIssuer;
    this.sourceAssetType = sourceAssetType;
    this.sourceAssetCode = sourceAssetCode;
    this.sourceAssetIssuer = sourceAssetIssuer;
  }

  public String getAmount() {
    return amount;
  }

  public String getSourceMax() {
    return sourceMax;
  }

  public KeyPair getFrom() {
    return from;
  }

  public KeyPair getTo() {
    return to;
  }

  public Asset getAsset() {
    if (assetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      KeyPair issuer = KeyPair.fromAccountId(assetIssuer);
      return Asset.createNonNativeAsset(assetCode, issuer);
    }
  }

  public Asset getSourceAsset() {
    if (sourceAssetCode.equals("native")) {
      return new AssetTypeNative();
    } else {
      KeyPair issuer = KeyPair.fromAccountId(sourceAssetIssuer);
      return Asset.createNonNativeAsset(sourceAssetCode, issuer);
    }
  }
}
