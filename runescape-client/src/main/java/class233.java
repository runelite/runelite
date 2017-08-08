import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public enum class233 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field3182("runescape", "RuneScape", 0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field3173("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field3176("game3", "Game 3", 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field3177("game4", "Game 4", 3),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field3180("game5", "Game 5", 4),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field3174("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("v")
   public final String field3175;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -277421419
   )
   final int field3179;

   class233(String var3, String var4, int var5) {
      this.field3175 = var3;
      this.field3179 = var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field3179;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "([Lhg;II)V",
      garbageValue = "-1720787018"
   )
   static final void method4107(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class41.method543(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && class41.method543(var3) && var3 != class43.field569) {
                  continue;
               }

               method4107(var0, var3.id);
               if(var3.children != null) {
                  method4107(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(class10.loadWidget(var5)) {
                     method4107(Item.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2633 != -1 || var3.field2620 != -1) {
                  boolean var4 = MessageNode.method1132(var3);
                  if(var4) {
                     var5 = var3.field2620;
                  } else {
                     var5 = var3.field2633;
                  }

                  if(var5 != -1) {
                     Sequence var6 = Ignore.getAnimation(var5);

                     for(var3.field2746 += Client.field1020; var3.field2746 > var6.frameLenghts[var3.field2745]; class255.method4531(var3)) {
                        var3.field2746 -= var6.frameLenghts[var3.field2745];
                        ++var3.field2745;
                        if(var3.field2745 >= var6.frameIDs.length) {
                           var3.field2745 -= var6.frameStep;
                           if(var3.field2745 < 0 || var3.field2745 >= var6.frameIDs.length) {
                              var3.field2745 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2679 != 0 && !var3.hasScript) {
                  int var8 = var3.field2679 >> 16;
                  var5 = var3.field2679 << 16 >> 16;
                  var8 *= Client.field1020;
                  var5 *= Client.field1020;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class255.method4531(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Lhg;IIIB)V",
      garbageValue = "2"
   )
   static final void method4110(Widget var0, int var1, int var2, int var3) {
      class211 var4 = var0.method4008(false);
      if(var4 != null) {
         if(Client.field1138 < 3) {
            class12.compass.method5184(var1, var2, var4.field2577, var4.field2578, 25, 25, Client.mapAngle, 256, var4.field2581, var4.field2579);
         } else {
            Rasterizer2D.method4988(var1, var2, 0, var4.field2581, var4.field2579);
         }

      }
   }
}
