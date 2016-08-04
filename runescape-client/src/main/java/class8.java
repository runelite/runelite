import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class8 {
   @ObfuscatedName("r")
   boolean field143;
   @ObfuscatedName("cd")
   static class227 field144;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -597087619
   )
   static int field145 = 4;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 278340323
   )
   int field146 = 1;
   @ObfuscatedName("s")
   LinkedHashMap field147 = new LinkedHashMap();
   @ObfuscatedName("e")
   boolean field148;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -292844125
   )
   @Export("cameraZ")
   static int field149;
   @ObfuscatedName("pk")
   static short[] field151;
   @ObfuscatedName("w")
   public static class231[] field152;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-111"
   )
   void method115(boolean var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass122;",
      garbageValue = "-856932176"
   )
   class122 method116() {
      class122 var1 = new class122(100);
      var1.method2783(field145);
      var1.method2783(this.field143?1:0);
      var1.method2783(this.field148?1:0);
      var1.method2783(this.field146);
      var1.method2783(this.field147.size());
      Iterator var2 = this.field147.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2728(((Integer)var3.getKey()).intValue());
         var1.method2728(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   class8(class122 var1) {
      if(var1 != null && var1.field2051 != null) {
         int var2 = var1.method2633();
         if(var2 >= 0 && var2 <= field145) {
            if(var1.method2633() == 1) {
               this.field143 = true;
            }

            if(var2 > 1) {
               this.field148 = var1.method2633() == 1;
            }

            if(var2 > 3) {
               this.field146 = var1.method2633();
            }

            if(var2 > 2) {
               int var3 = var1.method2633();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2620();
                  int var6 = var1.method2620();
                  this.field147.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method115(true);
         }
      } else {
         this.method115(true);
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)V",
      garbageValue = "1481833034"
   )
   static void method117(class176 var0) {
      class176 var1 = var0.field2826 == -1?null:class134.method2983(var0.field2826);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class189.field3056;
         var3 = class39.field892;
      } else {
         var2 = var1.field2822;
         var3 = var1.field2823;
      }

      class101.method2286(var0, var2, var3, false);
      class36.method772(var0, var2, var3);
   }

   class8() {
      this.method115(true);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Lclass157;",
      garbageValue = "1148651492"
   )
   public static class157[] method122() {
      return new class157[]{class157.field2350, class157.field2342, class157.field2341, class157.field2349, class157.field2344, class157.field2345};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZLclass227;B)V",
      garbageValue = "-82"
   )
   public static void method123(class170 var0, class170 var1, boolean var2, class227 var3) {
      class55.field1187 = var0;
      class55.field1190 = var1;
      class55.field1198 = var2;
      class55.field1180 = class55.field1187.method3405(10);
      class47.field1072 = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "674605122"
   )
   static int method124(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
