import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class69 extends Node {
   @ObfuscatedName("ea")
   static class262 field820;
   @ObfuscatedName("p")
   Object[] field821;
   @ObfuscatedName("e")
   Widget field822;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1845261225
   )
   int field823;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1887699281
   )
   int field825;
   @ObfuscatedName("m")
   boolean field826;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 832886391
   )
   int field827;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -136248057
   )
   int field828;
   @ObfuscatedName("j")
   Widget field829;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1148904247
   )
   int field830;
   @ObfuscatedName("q")
   class219 field831;
   @ObfuscatedName("dl")
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("c")
   String field833;
   @ObfuscatedName("ca")
   static class153 field834;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 912032317
   )
   int field835;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-1412869385"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field3362.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field3366.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method4247(new Buffer(var2));
         }

         KitDefinition.field3362.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2094045495"
   )
   static final void method1035() {
      if(Player.field862 != null) {
         Player.field862.method1912();
      }

      if(class134.field2003 != null) {
         class134.field2003.method1912();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass219;I)V",
      garbageValue = "-220189025"
   )
   public void method1036(class219 var1) {
      this.field831 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1096371298"
   )
   public static int method1040(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class224.method3964(var0.charAt(var3));
      }

      return var2;
   }

   public class69() {
      this.field831 = class219.field2805;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "1658502683"
   )
   public void method1041(Object[] var1) {
      this.field821 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "2028879275"
   )
   public static String method1042(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }
}
