import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class10 extends class110 {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1707939277
   )
   static int field156;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 469153471
   )
   public static int field158;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      longValue = -883990438724544771L
   )
   static long field159;
   @ObfuscatedName("k")
   static class227 field161;
   @ObfuscatedName("cz")
   static class146 field163;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 2051110053
   )
   static int field164;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1918195967"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class217.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "113"
   )
   public boolean vmethod2408(int var1, int var2, int var3, CollisionData var4) {
      return super.field1962 == var2 && var3 == super.field1960;
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "828202078"
   )
   static String method135(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var7 = var0.indexOf("%" + var2);
               if(var7 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var7);
               int var6 = class13.method166(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var7 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(null != class16.field228) {
               var3 = class113.method2447(class16.field228.field2285);
               if(class16.field228.field2287 != null) {
                  var3 = (String)class16.field228.field2287;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZB)V",
      garbageValue = "38"
   )
   static void method136(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class16.method186(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class16.method186(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3817((long)var1.id);
      if(null != var5) {
         class47.method989(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("v")
   public static String method138(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class165.field2712[(int)(var6 - 37L * var0)];
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
}
