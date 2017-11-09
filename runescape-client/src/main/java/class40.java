import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class40 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field514;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field510;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field509;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field515;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field513;
   @ObfuscatedName("bm")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("x")
   public final String field512;

   static {
      field514 = new class40("details");
      field510 = new class40("compositemap");
      field509 = new class40("compositetexture");
      field515 = new class40("area");
      field513 = new class40("labels");
   }

   class40(String var1) {
      this.field512 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "2072615435"
   )
   static char method595(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "16711935"
   )
   public static boolean method597(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Ljf;IIIS)V",
      garbageValue = "1700"
   )
   static void method596(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1091 < 50 && Client.field1067 != 0) {
         if(var0.field3662 != null && var1 < var0.field3662.length) {
            int var4 = var0.field3662[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field910[Client.field1091] = var5;
               Client.field1093[Client.field1091] = var6;
               Client.field1094[Client.field1091] = 0;
               Client.audioEffects[Client.field1091] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1033[Client.field1091] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1091;
            }
         }
      }
   }
}
