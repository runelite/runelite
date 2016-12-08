import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -1015894959
   )
   public static int field1200;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1135212011
   )
   int field1201 = 128;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -582008053
   )
   int field1202;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -382545837
   )
   int field1203 = 0;
   @ObfuscatedName("o")
   class79[] field1204;
   @ObfuscatedName("l")
   class182 field1206;
   @ObfuscatedName("m")
   Deque field1207 = new Deque();
   @ObfuscatedName("h")
   double field1208 = 1.0D;
   @ObfuscatedName("qb")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("py")
   static Clipboard field1210;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1406(double var1) {
      this.field1208 = var1;
      this.method1411();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-2027168990"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1204[var1];
      if(var2 != null) {
         if(null != var2.field1309) {
            this.field1207.method2345(var2);
            var2.field1304 = true;
            return var2.field1309;
         }

         boolean var3 = var2.method1509(this.field1208, this.field1201, this.field1206);
         if(var3) {
            if(this.field1203 == 0) {
               class79 var4 = (class79)this.field1207.method2373();
               var4.method1516();
            } else {
               --this.field1203;
            }

            this.field1207.method2345(var2);
            var2.field1304 = true;
            return var2.field1309;
         }
      }

      return null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   public int vmethod1853(int var1) {
      return null != this.field1204[var1]?this.field1204[var1].field1301:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-93"
   )
   public boolean vmethod1864(int var1) {
      return this.field1204[var1].field1302;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-86"
   )
   public void method1410(int var1) {
      for(int var2 = 0; var2 < this.field1204.length; ++var2) {
         class79 var3 = this.field1204[var2];
         if(var3 != null && var3.field1307 != 0 && var3.field1304) {
            var3.method1511(var1);
            var3.field1304 = false;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2133440488"
   )
   public void method1411() {
      for(int var1 = 0; var1 < this.field1204.length; ++var1) {
         if(null != this.field1204[var1]) {
            this.field1204[var1].method1516();
         }
      }

      this.field1207 = new Deque();
      this.field1203 = this.field1202;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "3164661"
   )
   public boolean vmethod1856(int var1) {
      return this.field1201 == 64;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1206 = var2;
      this.field1202 = var3;
      this.field1203 = this.field1202;
      this.field1208 = var4;
      this.field1201 = var6;
      int[] var7 = var1.method3212(0);
      int var8 = var7.length;
      this.field1204 = new class79[var1.method3245(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3203(0, var7[var9]));
         this.field1204[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "-40"
   )
   static World method1431() {
      return World.field680 < World.field679?World.worldList[++World.field680 - 1]:null;
   }
}
