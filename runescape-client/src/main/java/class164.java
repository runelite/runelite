import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class164 extends CacheableNode {
   @ObfuscatedName("h")
   public final int[] field2154;
   @ObfuscatedName("p")
   public final int[] field2155;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 811543217
   )
   public final int field2156;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 356253821
   )
   public final int field2157;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1786578871
   )
   static int field2158;

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2156 = var1;
      this.field2157 = var2;
      this.field2154 = var3;
      this.field2155 = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-1"
   )
   public boolean method3156(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2155.length) {
         int var3 = this.field2155[var2];
         if(var1 >= var3 && var1 <= this.field2154[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LVarbit;",
      garbageValue = "-1965467944"
   )
   public static Varbit method3157(int var0) {
      Varbit var1 = (Varbit)Varbit.field2852.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfoListHolder.field784.getConfigData(14, var0);
         var1 = new Varbit();
         if(null != var2) {
            var1.method3549(new Buffer(var2));
         }

         Varbit.field2852.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-925483723"
   )
   static boolean method3158(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "0"
   )
   static final void method3159(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method3159(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2399((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class30.method696(var5)) {
                     method3159(Widget.widgets[var5], var1);
                  }
               }
            }

            class18 var6;
            if(var1 == 0 && var3.field2298 != null) {
               var6 = new class18();
               var6.field198 = var3;
               var6.field209 = var3.field2298;
               class174.method3275(var6, 200000);
            }

            if(var1 == 1 && null != var3.field2200) {
               if(var3.index >= 0) {
                  Widget var7 = class179.method3296(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new class18();
               var6.field198 = var3;
               var6.field209 = var3.field2200;
               class174.method3275(var6, 200000);
            }
         }
      }

   }
}
