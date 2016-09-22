import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class50 extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2011038375
   )
   public int field1110;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2101888595
   )
   public int field1111;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -267050353
   )
   public int field1113;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1368351837
   )
   static int field1115;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1345446461
   )
   static int field1116;
   @ObfuscatedName("d")
   static NodeCache field1118 = new NodeCache(64);
   @ObfuscatedName("an")
   static class171 field1121;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "14"
   )
   void method1032(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method1042(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-1478444982"
   )
   public static void method1033(class170 var0) {
      class47.field1064 = var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "0"
   )
   public static byte[] method1039(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class16.method185(var3):var3;
      } else if(var0 instanceof class128) {
         class128 var2 = (class128)var0;
         return var2.vmethod2825();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "114"
   )
   void method1042(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1111 = var1.method2717();
         this.field1110 = var1.method2528();
         this.field1113 = var1.method2528();
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-519185870"
   )
   static final void method1044(int var0, int var1) {
      int var2 = Frames.field1850.method4065("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = Frames.field1850.method4065(class16.method182(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class159.field2374) {
         var4 = class159.field2374 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class92.field1643) {
         var5 = class92.field1643 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      VertexNormal.menuX = var4;
      class14.menuY = var5;
      class85.menuWidth = var2;
      Renderable.menuHeight = 22 + Client.menuOptionCount * 15;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIIZB)V",
      garbageValue = "10"
   )
   public static void method1046(class170 var0, int var1, int var2, int var3, boolean var4) {
      class186.field3016 = 1;
      class186.field3017 = var0;
      class186.field3019 = var1;
      class186.field3022 = var2;
      class177.field2951 = var3;
      class186.field3020 = var4;
      class21.field585 = 10000;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "1779308073"
   )
   public static int method1047(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = 1 + (var0 << 4);
      }

      return var2;
   }
}
