import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public final class class31 extends Node {
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 792294327
   )
   static int field698;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 309640293
   )
   int field699;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1507564617
   )
   int field700;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2138104929
   )
   int field701;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1568889761
   )
   int field702;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 128406323
   )
   int field703;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1802267007
   )
   int field704;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1355031319
   )
   int field705;
   @ObfuscatedName("i")
   static Deque field706 = new Deque();
   @ObfuscatedName("p")
   int[] field707;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1740925901
   )
   int field708;
   @ObfuscatedName("w")
   class66 field709;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -32752387
   )
   int field710;
   @ObfuscatedName("m")
   ObjectComposition field712;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 168928665
   )
   int field713;
   @ObfuscatedName("c")
   class66 field714;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-8024"
   )
   void method637() {
      int var1 = this.field705;
      ObjectComposition var2 = this.field712.getImpostor();
      if(var2 != null) {
         this.field705 = var2.field2936;
         this.field704 = var2.field2920 * 128;
         this.field713 = var2.field2938;
         this.field708 = var2.field2902;
         this.field707 = var2.field2940;
      } else {
         this.field705 = -1;
         this.field704 = 0;
         this.field713 = 0;
         this.field708 = 0;
         this.field707 = null;
      }

      if(this.field705 != var1 && this.field709 != null) {
         class0.field3.method911(this.field709);
         this.field709 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-5"
   )
   public static void method638(int var0, int var1) {
      class194 var2 = class25.method555(var0);
      int var3 = var2.field2848;
      int var4 = var2.field2849;
      int var5 = var2.field2852;
      int var6 = class165.field2170[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class165.widgetSettings[var3] = class165.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1681537498"
   )
   static final void method648(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var1 == var3.parentId && (!var3.field2198 || !class221.method3975(var3))) {
            if(var3.type == 0) {
               if(!var3.field2198 && class221.method3975(var3) && var3 != FaceNormal.field1558) {
                  continue;
               }

               method648(var0, var3.id);
               if(var3.children != null) {
                  method648(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.method2311((long)var3.id);
               if(null != var7) {
                  ChatMessages.method834(var7.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2255 != -1 || var3.field2256 != -1) {
                  boolean var4 = class16.method176(var3);
                  if(var4) {
                     var5 = var3.field2256;
                  } else {
                     var5 = var3.field2255;
                  }

                  if(var5 != -1) {
                     Sequence var6 = GameEngine.getAnimation(var5);

                     for(var3.field2251 += Client.field364; var3.field2251 > var6.frameLenghts[var3.field2330]; class94.method1890(var3)) {
                        var3.field2251 -= var6.frameLenghts[var3.field2330];
                        ++var3.field2330;
                        if(var3.field2330 >= var6.frameIDs.length) {
                           var3.field2330 -= var6.frameStep;
                           if(var3.field2330 < 0 || var3.field2330 >= var6.frameIDs.length) {
                              var3.field2330 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2244 != 0 && !var3.field2198) {
                  int var8 = var3.field2244 >> 16;
                  var5 = var3.field2244 << 16 >> 16;
                  var8 *= Client.field364;
                  var5 *= Client.field364;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var3.rotationZ + var5 & 2047;
                  class94.method1890(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "-95"
   )
   public static void method649(class182 var0) {
      class150.field2048 = var0;
   }
}
