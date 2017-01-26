import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public final class class85 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2064379633
   )
   int field1454;
   @ObfuscatedName("k")
   boolean field1455 = true;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 111927751
   )
   int field1456;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1079382855
   )
   int field1457;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1445384811
   )
   int field1458;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1340334187
   )
   int field1459;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 741396291
   )
   int field1461;

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2005849146"
   )
   static final void method1690() {
      Client.field394.method3037(111);
      Client.field394.method2799(0);
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1456 = var1;
      this.field1454 = var2;
      this.field1461 = var3;
      this.field1458 = var4;
      this.field1457 = var5;
      this.field1459 = var6;
      this.field1455 = var7;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "1528276051"
   )
   public static int method1691(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class185.field2745 + class185.field2747;
      return var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1502883900"
   )
   static final void method1692() {
      if(class47.field935 != null) {
         class47.field935.method1059();
      }

      if(null != class186.field2763) {
         class186.field2763.method1059();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILclass182;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-218886652"
   )
   public static void method1693(int var0, class182 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3276(var2);
      int var7 = var1.method3287(var6, var3);
      NPCComposition.method3725(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "113"
   )
   static void method1694() {
      FileOnDisk var0 = null;

      try {
         var0 = class37.method728("", class155.field2107.field2688, true);
         Buffer var1 = class107.field1733.method656();
         var0.method1402(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1403();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
