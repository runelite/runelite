import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class2 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 3706179478591958731L
   )
   public final long field11;
   @ObfuscatedName("g")
   public final XGrandExchangeOffer field13;
   @ObfuscatedName("v")
   String field14;
   @ObfuscatedName("y")
   String field15;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -628842743
   )
   public final int field16;

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1306807261"
   )
   static final int method23() {
      return Client.menuOptionCount <= 0?-1:(Client.field437 && class105.field1718[81] && Client.field436 != -1?Client.field436:Client.menuOptionCount - 1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1729850710"
   )
   public String method24() {
      return this.field15;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-116946704"
   )
   public String method30() {
      return this.field14;
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field14 = var1.readString();
      this.field15 = var1.readString();
      this.field16 = var1.readUnsignedShort();
      this.field11 = var1.method2892();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field13 = new XGrandExchangeOffer();
      this.field13.method51(2);
      this.field13.method70(var2);
      this.field13.price = var4;
      this.field13.totalQuantity = var5;
      this.field13.quantitySold = 0;
      this.field13.spent = 0;
      this.field13.itemId = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "0"
   )
   public static File method32(String var0) {
      if(!class107.field1734) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1736.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class107.field1733, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class107.field1736.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)Lclass112;",
      garbageValue = "-4089"
   )
   public static class112 method33() {
      try {
         return new class106();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-3"
   )
   static final int method34(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class189.method3526(var3, var5);
      int var8 = class189.method3526(var3 + 1, var5);
      int var9 = class189.method3526(var3, var5 + 1);
      int var10 = class189.method3526(1 + var3, 1 + var5);
      int var12 = 65536 - class84.field1446[var4 * 1024 / var2] >> 1;
      int var11 = (var8 * var12 >> 16) + ((65536 - var12) * var7 >> 16);
      int var14 = 65536 - class84.field1446[1024 * var4 / var2] >> 1;
      int var13 = (var14 * var10 >> 16) + ((65536 - var14) * var9 >> 16);
      int var16 = 65536 - class84.field1446[1024 * var6 / var2] >> 1;
      int var15 = (var13 * var16 >> 16) + ((65536 - var16) * var11 >> 16);
      return var15;
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1338416716"
   )
   static final void method35(String var0) {
      if(!var0.equals("")) {
         Client.field332.method3144(194);
         Client.field332.method2873(class165.method3233(var0));
         Client.field332.method2915(var0);
      }
   }
}
