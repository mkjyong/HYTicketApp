/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package module.nrlwallet.com.nrlwalletsdk.Bitcoin.bitcoinj.wallet;

/**
 * Thrown by the {@link WalletProtobufSerializer} when the serialized protocol buffer is either corrupted,
 * internally inconsistent or appears to be from the future.
 */
public class UnreadableWalletException extends Exception {
    public UnreadableWalletException(String s) {
        super(s);
    }

    public UnreadableWalletException(String s, Throwable t) {
        super(s, t);
    }

    public static class BadPassword extends UnreadableWalletException {
        public BadPassword() {
            super("Password incorrect");
        }
    }

    public static class FutureVersion extends UnreadableWalletException {
        public FutureVersion() { super("Unknown wallet version from the future."); }
    }

    public static class WrongNetwork extends UnreadableWalletException {
        public WrongNetwork() {
            super("Mismatched network ID");
        }
    }
}
