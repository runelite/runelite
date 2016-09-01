import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class52 extends CacheableNode {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 379118149
   )
   public int field1118 = 0;
   @ObfuscatedName("r")
   static NodeCache field1119 = new NodeCache(64);
   @ObfuscatedName("j")
   public char field1120;
   @ObfuscatedName("z")
   public char field1121;
   @ObfuscatedName("f")
   public String[] field1122;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -447968375
   )
   public int field1123;
   @ObfuscatedName("m")
   public int[] field1125;
   @ObfuscatedName("x")
   static class170 field1127;
   @ObfuscatedName("p")
   public int[] field1128;
   @ObfuscatedName("i")
   public String field1132 = "null";

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1841171286"
   )
   void method1057(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1058(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-881523785"
   )
   void method1058(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1120 = (char)var1.method2556();
      } else if(var2 == 2) {
         this.field1121 = (char)var1.method2556();
      } else if(var2 == 3) {
         this.field1132 = var1.method2774();
      } else if(var2 == 4) {
         this.field1123 = var1.method2561();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1118 = var1.method2551();
            this.field1125 = new int[this.field1118];
            this.field1122 = new String[this.field1118];

            for(var3 = 0; var3 < this.field1118; ++var3) {
               this.field1125[var3] = var1.method2561();
               this.field1122[var3] = var1.method2774();
            }
         } else if(var2 == 6) {
            this.field1118 = var1.method2551();
            this.field1125 = new int[this.field1118];
            this.field1128 = new int[this.field1118];

            for(var3 = 0; var3 < this.field1118; ++var3) {
               this.field1125[var3] = var1.method2561();
               this.field1128[var3] = var1.method2561();
            }
         }
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-625909789"
   )
   static final void method1059(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3) {
            if(var3.type == 0) {
               if(null != var3.children) {
                  method1059(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3830((long)var3.id);
               if(null != var4) {
                  int var5 = var4.id;
                  if(class175.method3419(var5)) {
                     method1059(Widget.widgets[var5], var1);
                  }
               }
            }

            class0 var6;
            if(var1 == 0 && var3.field2893 != null) {
               var6 = new class0();
               var6.field7 = var3;
               var6.field8 = var3.field2893;
               class158.method3201(var6, 200000);
            }

            if(var1 == 1 && null != var3.field2930) {
               if(var3.index >= 0) {
                  Widget var7 = World.method628(var3.id);
                  if(null == var7 || var7.children == null || var3.index >= var7.children.length || var7.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new class0();
               var6.field7 = var3;
               var6.field8 = var3.field2930;
               class158.method3201(var6, 200000);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass54;",
      garbageValue = "954277485"
   )
   public static class54 method1069(int var0) {
      class54 var1 = (class54)class54.field1143.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class54.field1150.method3290(5, var0);
         var1 = new class54();
         if(var2 != null) {
            var1.method1089(new Buffer(var2));
         }

         class54.field1143.put(var1, (long)var0);
         return var1;
      }
   }
}
