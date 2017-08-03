import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class31 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2062777737
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1636651773
   )
   final int field422;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 633537861
   )
   final int field417;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1946155559
   )
   final int field416;

   class31(int var1, int var2, int var3) {
      this.field422 = var1;
      this.field417 = var2;
      this.field416 = var3;
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "([Lhn;IB)V",
      garbageValue = "29"
   )
   static final void method272(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class177.method3423(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class177.method3423(var3) && var3 != class244.field3302) {
                  continue;
               }

               method272(var0, var3.id);
               if(var3.children != null) {
                  method272(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  class54.method804(var7.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2676 != -1 || var3.field2734 != -1) {
                  boolean var4 = World.method1597(var3);
                  if(var4) {
                     var5 = var3.field2734;
                  } else {
                     var5 = var3.field2676;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class40.getAnimation(var5);

                     for(var3.field2699 += Client.field1078; var3.field2699 > var6.frameLenghts[var3.field2751]; class48.method732(var3)) {
                        var3.field2699 -= var6.frameLenghts[var3.field2751];
                        ++var3.field2751;
                        if(var3.field2751 >= var6.frameIDs.length) {
                           var3.field2751 -= var6.frameStep;
                           if(var3.field2751 < 0 || var3.field2751 >= var6.frameIDs.length) {
                              var3.field2751 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2618 != 0 && !var3.hasScript) {
                  int var8 = var3.field2618 >> 16;
                  var5 = var3.field2618 << 16 >> 16;
                  var8 *= Client.field1078;
                  var5 *= Client.field1078;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class48.method732(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "-79"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class9.method48(var0, MouseInput.field715);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class9.method48(Client.friends[var3].name, MouseInput.field715)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class9.method48(class224.localPlayer.name, MouseInput.field715))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lim;III)Ljw;",
      garbageValue = "-1871409236"
   )
   static IndexedSprite method273(IndexDataBase var0, int var1, int var2) {
      if(!WallObject.method2899(var0, var1, var2)) {
         return null;
      } else {
         IndexedSprite var4 = new IndexedSprite();
         var4.width = class286.field3779;
         var4.originalHeight = class286.field3780;
         var4.offsetX = class270.field3666[0];
         var4.offsetY = class286.offsetsY[0];
         var4.originalWidth = class286.field3778[0];
         var4.height = class286.field3782[0];
         var4.palette = class286.field3783;
         var4.pixels = class177.spritePixels[0];
         class229.method4093();
         return var4;
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lcj;II)V",
      garbageValue = "163499978"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      BaseVarType.method12(var0.x, var0.y, var1);
   }
}
