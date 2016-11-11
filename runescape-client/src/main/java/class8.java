import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class8 {
   @ObfuscatedName("iv")
   static class32 field153;
   @ObfuscatedName("e")
   boolean field154;
   @ObfuscatedName("u")
   LinkedHashMap field155 = new LinkedHashMap();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -729782469
   )
   static int field156 = 4;
   @ObfuscatedName("g")
   boolean field157;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1725642273
   )
   int field161 = 1;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "2145657497"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field1013.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class170 var3 = Sequence.field1007;
         class170 var4 = Sequence.field1008;
         boolean var5 = true;
         int[] var6 = var3.method3298(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3295(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3295(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(null != var2) {
            Sequence.field1013.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2005704222"
   )
   void method106(boolean var1) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "-1516300606"
   )
   Buffer method107() {
      Buffer var1 = new Buffer(100);
      var1.method2529(field156);
      var1.method2529(this.field154?1:0);
      var1.method2529(this.field157?1:0);
      var1.method2529(this.field161);
      var1.method2529(this.field155.size());
      Iterator var2 = this.field155.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2709(((Integer)var3.getKey()).intValue());
         var1.method2709(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   class8() {
      this.method106(true);
   }

   class8(Buffer var1) {
      if(var1 != null && null != var1.payload) {
         int var2 = var1.method2544();
         if(var2 >= 0 && var2 <= field156) {
            if(var1.method2544() == 1) {
               this.field154 = true;
            }

            if(var2 > 1) {
               this.field157 = var1.method2544() == 1;
            }

            if(var2 > 3) {
               this.field161 = var1.method2544();
            }

            if(var2 > 2) {
               int var3 = var1.method2544();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2549();
                  int var6 = var1.method2549();
                  this.field155.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method106(true);
         }
      } else {
         this.method106(true);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-669640912"
   )
   static void method115() {
      for(class24 var0 = (class24)class24.field634.method3845(); null != var0; var0 = (class24)class24.field634.method3847()) {
         if(var0.field632 != null) {
            class0.field11.method1178(var0.field632);
            var0.field632 = null;
         }

         if(var0.field635 != null) {
            class0.field11.method1178(var0.field635);
            var0.field635 = null;
         }
      }

      class24.field634.method3863();
   }
}
