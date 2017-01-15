import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class18 extends Node {
   @ObfuscatedName("x")
   boolean field189;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 27214169
   )
   int field190;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -363689273
   )
   int field191;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1307088743
   )
   int field192;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1207785977
   )
   int field193;
   @ObfuscatedName("d")
   Widget field194;
   @ObfuscatedName("i")
   Widget field195;
   @ObfuscatedName("z")
   String field197;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -740052757
   )
   int field198;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2061234831
   )
   int field201;
   @ObfuscatedName("u")
   Object[] field203;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "200145694"
   )
   static void method186(int var0) {
      if(var0 != -1 && class94.method1870(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3.field2266) {
               class18 var4 = new class18();
               var4.field195 = var3;
               var4.field203 = var3.field2266;
               class49.method871(var4, 2000000);
            }
         }
      }

   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   static void method187() {
      if(Client.field435) {
         Widget var0 = class157.method3011(class2.field16, Client.field436);
         if(var0 != null && var0.field2297 != null) {
            class18 var1 = new class18();
            var1.field195 = var0;
            var1.field203 = var0.field2297;
            class49.method871(var1, 200000);
         }

         Client.field435 = false;
         class6.method87(var0);
      }

   }
}
