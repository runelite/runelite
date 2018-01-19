import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("h")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -249748321
   )
   @Export("ordinal")
   public final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-486058577"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class299.field3872 = var1.readUnsignedShort();
      class299.field3870 = new int[class299.field3872];
      class299.offsetsY = new int[class299.field3872];
      class54.field635 = new int[class299.field3872];
      UrlRequester.field2099 = new int[class299.field3872];
      class188.spritePixels = new byte[class299.field3872][];
      var1.offset = var0.length - 7 - class299.field3872 * 8;
      class299.field3868 = var1.readUnsignedShort();
      class299.field3867 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class299.field3872; ++var3) {
         class299.field3870[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class299.field3872; ++var3) {
         class299.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class299.field3872; ++var3) {
         class54.field635[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class299.field3872; ++var3) {
         UrlRequester.field2099[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class299.field3872 * 8 - (var2 - 1) * 3;
      class299.field3869 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class299.field3869[var3] = var1.read24BitInt();
         if(class299.field3869[var3] == 0) {
            class299.field3869[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class299.field3872; ++var3) {
         int var4 = class54.field635[var3];
         int var5 = UrlRequester.field2099[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class188.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "([Lhq;II)V",
      garbageValue = "2120697385"
   )
   static final void method4291(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class20.method150(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && class20.method150(var3) && var3 != BoundingBox.field239) {
                  continue;
               }

               method4291(var0, var3.id);
               if(var3.children != null) {
                  method4291(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(FontName.loadWidget(var5)) {
                     method4291(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2749 != -1 || var3.field2810 != -1) {
                  boolean var7 = Client.method1223(var3);
                  if(var7) {
                     var5 = var3.field2810;
                  } else {
                     var5 = var3.field2749;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class45.getAnimation(var5);

                     for(var3.field2885 += Client.field944; var3.field2885 > var6.frameLenghts[var3.field2884]; class28.method220(var3)) {
                        var3.field2885 -= var6.frameLenghts[var3.field2884];
                        ++var3.field2884;
                        if(var3.field2884 >= var6.frameIDs.length) {
                           var3.field2884 -= var6.frameStep;
                           if(var3.field2884 < 0 || var3.field2884 >= var6.frameIDs.length) {
                              var3.field2884 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2818 != 0 && !var3.hasScript) {
                  int var8 = var3.field2818 >> 16;
                  var5 = var3.field2818 << 16 >> 16;
                  var8 *= Client.field944;
                  var5 *= Client.field944;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class28.method220(var3);
               }
            }
         }
      }

   }
}
