import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("WidgetGroupParent")
public class WidgetGroupParent extends Node {
   @ObfuscatedName("px")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("sceneMinimapSprite")
   static Sprite sceneMinimapSprite;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -992379173
   )
   @Export("__bx_o")
   static int __bx_o;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -707461797
   )
   @Export("group")
   int group;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1712037041
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   @Export("keep")
   boolean keep;

   WidgetGroupParent() {
      this.keep = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Lcg;",
      garbageValue = "1"
   )
   static Script method1175(int var0, int var1) {
      Script var2 = (Script)Script.Script_cached.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = Formatting.indexCache12.getArchiveId(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = Formatting.indexCache12.takeRecordFlat(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = Occluder.newScript(var5);
               if(var2 != null) {
                  Script.Script_cached.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "619422509"
   )
   @Export("decodeStringCp1252")
   public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class304.cp1252AsciiExtension[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "32"
   )
   static int method1174(int var0) {
      ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(Integer.valueOf(var0));
      return var1 == null?0:var1.size();
   }
}
