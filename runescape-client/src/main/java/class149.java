import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class149 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static IndexData field2115;
   @ObfuscatedName("m")
   final URL field2111;
   @ObfuscatedName("p")
   volatile boolean field2114;
   @ObfuscatedName("i")
   volatile byte[] field2113;

   class149(URL var1) {
      this.field2111 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2128019411"
   )
   public boolean method3015() {
      return this.field2114;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-551650513"
   )
   public byte[] method3016() {
      return this.field2113;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-417050690"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class89.method1798(var3):var3;
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
