import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class8 {
   @ObfuscatedName("x")
   boolean field140;
   @ObfuscatedName("b")
   boolean field141;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 977828063
   )
   int field142 = 1;
   @ObfuscatedName("bp")
   static class168 field143;
   @ObfuscatedName("eo")
   static class78[] field144;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      longValue = -8965268795532634403L
   )
   static long field145;
   @ObfuscatedName("d")
   LinkedHashMap field146 = new LinkedHashMap();
   @ObfuscatedName("g")
   static int[][] field147;
   @ObfuscatedName("mc")
   static byte field148;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2119114091
   )
   static int field149 = 4;
   @ObfuscatedName("dn")
   static byte[][] field150;

   class8() {
      this.method115(true);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "623409401"
   )
   static final void method114() {
      if(class6.field128 != null) {
         class6.field128.method1251();
      }

      if(class39.field923 != null) {
         class39.field923.method1251();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1553294430"
   )
   void method115(boolean var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass119;",
      garbageValue = "-2004053561"
   )
   class119 method116() {
      class119 var1 = new class119(100);
      var1.method2654(field149);
      var1.method2654(this.field140?1:0);
      var1.method2654(this.field141?1:0);
      var1.method2654(this.field142);
      var1.method2654(this.field146.size());
      Iterator var2 = this.field146.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2539(((Integer)var3.getKey()).intValue());
         var1.method2539(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("si")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-460604693"
   )
   protected static final void method120() {
      class107.field1884.vmethod3146();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         class144.field2201[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         class144.field2199[var0] = 0L;
      }

      class52.field1174 = 0;
   }

   class8(class119 var1) {
      if(var1 != null && null != var1.field2000) {
         int var2 = var1.method2554();
         if(var2 >= 0 && var2 <= field149) {
            if(var1.method2554() == 1) {
               this.field140 = true;
            }

            if(var2 > 1) {
               this.field141 = var1.method2554() == 1;
            }

            if(var2 > 3) {
               this.field142 = var1.method2554();
            }

            if(var2 > 2) {
               int var3 = var1.method2554();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2696();
                  int var6 = var1.method2696();
                  this.field146.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method115(true);
         }
      } else {
         this.method115(true);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)[Lclass78;",
      garbageValue = "646453770"
   )
   public static class78[] method128(class167 var0, String var1, String var2) {
      int var3 = var0.method3300(var1);
      int var4 = var0.method3301(var3, var2);
      class78[] var5;
      if(!class94.method2227(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class4.method52();
      }

      return var5;
   }
}
