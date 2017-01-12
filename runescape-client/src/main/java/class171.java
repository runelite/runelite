import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class171 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1951106969
   )
   static int field2331;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1998126030"
   )
   static void method3232() {
      Object var0 = class183.field2706;
      synchronized(class183.field2706) {
         if(class183.field2704 == 0) {
            class44.field881.method1916(new class183(), 5);
         }

         class183.field2704 = 600;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1997565586"
   )
   static void method3233(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)V",
      garbageValue = "6"
   )
   public static void method3234(class182 var0, class182 var1) {
      KitDefinition.field2800 = var0;
      KitDefinition.field2810 = var1;
      class155.field2093 = KitDefinition.field2800.method3323(3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "-1710775688"
   )
   public static int method3235(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class44.method797(var9);
         var8 = class44.method797(var10);
         var9 = class150.method2748(var9, var2);
         var10 = class150.method2748(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return FrameMap.method1667(var9, var2) - FrameMap.method1667(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var12 != var11 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return FrameMap.method1667(var11, var2) - FrameMap.method1667(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var13 != var12) {
               return FrameMap.method1667(var12, var2) - FrameMap.method1667(var13, var2);
            }
         }

         return 0;
      }
   }
}
