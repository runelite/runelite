import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
@Implements("ChatPlayer")
public class ChatPlayer extends Nameable {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 210795971
   )
   @Export("world")
   public int world;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 488130351
   )
   public int field3845;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 958560583
   )
   @Export("rank")
   public int rank;

   ChatPlayer() {
      this.world = -1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "382794867"
   )
   void method5389(int var1, int var2) {
      this.world = var1;
      this.field3845 = var2;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1259198744"
   )
   public int method5390() {
      return this.world;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   public boolean method5391() {
      return this.world > 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-985075976"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class314.cp1252AsciiExtension[var6 - 128];
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
}
