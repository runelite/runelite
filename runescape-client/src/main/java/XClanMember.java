import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("i")
   @Export("username")
   String username;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -642545351
   )
   @Export("world")
   int world;
   @ObfuscatedName("w")
   String field919;
   @ObfuscatedName("t")
   @Export("rank")
   byte rank;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;Lclass186;I)Lclass186;",
      garbageValue = "-1157317928"
   )
   static final class186 method1181(Buffer var0, class186 var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class56.method849(var2);
         var1 = new class186(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new class185(var0.readString());
         } else {
            var6 = new WidgetConfig(var0.readInt());
         }

         var1.method3479((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("w")
   public static String method1182(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class268.field3681[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
