import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -254887449
   )
   static int field2136;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -696837367
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 529093423
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 591492731
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -679614565
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2024178417
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1462581815
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 164525907
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1177051805
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2017291905
   )
   @Export("rotation")
   int rotation;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("i")
   public static String method2833(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class268.field3654[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-1220034008"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class215.method3908(var0, class22.field331);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class215.method3908(Client.friends[var3].name, class22.field331)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class215.method3908(class226.localPlayer.name, class22.field331))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1075732825"
   )
   static int method2834(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
      } else {
         var3 = var2?class48.field614:FaceNormal.field2099;
      }

      if(var0 == 1927) {
         if(class83.field1333 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2672 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field831 = var3.field2672;
            var4.field839 = class83.field1333 + 1;
            Client.field1103.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1444588260"
   )
   static int method2831(int var0) {
      MessageNode var1 = (MessageNode)class98.field1495.get((long)var0);
      return var1 == null?-1:(var1.previous == class98.field1493.field2456?-1:((MessageNode)var1.previous).id);
   }
}
