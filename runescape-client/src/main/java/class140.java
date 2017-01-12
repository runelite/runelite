import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class140 extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1493724957
   )
   int field1935;
   @ObfuscatedName("eb")
   static SpritePixels[] field1936;
   @ObfuscatedName("i")
   class55 field1937;
   @ObfuscatedName("a")
   class137 field1938;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -985504321
   )
   int field1939;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 116181389
   )
   int field1940;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1389070155
   )
   int field1941;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -545777249
   )
   int field1942;
   @ObfuscatedName("x")
   class142 field1943;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 541704869
   )
   int field1944;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1938059975
   )
   int field1945;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 220666851
   )
   int field1946;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 732382125
   )
   int field1947;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1359889549
   )
   int field1949;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1282265457
   )
   int field1950;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -730920873
   )
   int field1951;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1724780701
   )
   int field1952;
   @ObfuscatedName("r")
   class66 field1953;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 568360831
   )
   int field1954;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1325928881
   )
   int field1955;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 593456113
   )
   int field1957;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1247731867
   )
   int field1959;
   @ObfuscatedName("ni")
   static class65 field1961;

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "1165782671"
   )
   static Widget method2605(Widget var0) {
      int var1 = class39.method736(GameObject.method1872(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class44.method799(var0.parentId);
            if(null == var0) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-8"
   )
   static void method2606(int var0, int var1) {
      Client.field326.method3029(148);
      Client.field326.method2763(var0);
      Client.field326.method2918(var1);
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-2095171738"
   )
   static final void method2607(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(null != var3.children) {
                  method2607(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2339((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class94.method1870(var5)) {
                     method2607(Widget.widgets[var5], var1);
                  }
               }
            }

            class18 var6;
            if(var1 == 0 && var3.field2292 != null) {
               var6 = new class18();
               var6.field195 = var3;
               var6.field203 = var3.field2292;
               class49.method871(var6, 200000);
            }

            if(var1 == 1 && var3.field2293 != null) {
               if(var3.index >= 0) {
                  Widget var7 = class44.method799(var3.id);
                  if(var7 == null || null == var7.children || var3.index >= var7.children.length || var7.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new class18();
               var6.field195 = var3;
               var6.field203 = var3.field2293;
               class49.method871(var6, 200000);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1069224461"
   )
   void method2608() {
      this.field1943 = null;
      this.field1937 = null;
      this.field1938 = null;
      this.field1953 = null;
   }
}
