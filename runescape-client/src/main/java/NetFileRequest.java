import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache")
   public IndexCache indexCache;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1487103265
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("q")
   @Export("padding")
   public byte padding;

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "([Lho;II)V",
      garbageValue = "1807602893"
   )
   static final void method4555(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.isIf3 || !PacketBufferNode.method3673(var3))) {
            if(var3.type == 0) {
               if(!var3.isIf3 && PacketBufferNode.method3673(var3) && var3 != Clock.mousedOverWidgetIf1) {
                  continue;
               }

               method4555(var0, var3.id);
               if(var3.children != null) {
                  method4555(var3.children, var3.id);
               }

               WidgetGroupParent var7 = (WidgetGroupParent)Client.widgetGroupParents.get((long)var3.id);
               if(var7 != null) {
                  ClientPreferences.method1809(var7.group);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.sequenceId != -1 || var3.sequenceId2 != -1) {
                  boolean var4 = class238.runCs1(var3);
                  if(var4) {
                     var5 = var3.sequenceId2;
                  } else {
                     var5 = var3.sequenceId;
                  }

                  if(var5 != -1) {
                     SequenceDefinition var6 = WorldMapAreaData.getSequenceDefinition(var5);

                     for(var3.modelFrameCycle += Client.__client_gy; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; class22.method295(var3)) {
                        var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
                        ++var3.modelFrame;
                        if(var3.modelFrame >= var6.frameIds.length) {
                           var3.modelFrame -= var6.frameCount;
                           if(var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
                              var3.modelFrame = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.__bh != 0 && !var3.isIf3) {
                  int var8 = var3.__bh >> 16;
                  var5 = var3.__bh << 16 >> 16;
                  var8 *= Client.__client_gy;
                  var5 *= Client.__client_gy;
                  var3.modelAngleX = var8 + var3.modelAngleX & 2047;
                  var3.modelAngleY = var5 + var3.modelAngleY & 2047;
                  class22.method295(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(IIIILln;Lhp;B)V",
      garbageValue = "-37"
   )
   static final void method4554(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
      if(var4 != null) {
         int var6 = Client.minimapOrientation & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
            int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.__ac_512(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
            } else {
               var4.drawAt2(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
            }

         }
      }
   }
}
