import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class18 extends Node {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1942722479
   )
   int field187;
   @ObfuscatedName("g")
   Widget field188;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 522028383
   )
   int field189;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1310124455
   )
   int field190;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -971329953
   )
   int field191;
   @ObfuscatedName("j")
   Widget field192;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1056712191
   )
   int field193;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2123867675
   )
   int field194;
   @ObfuscatedName("i")
   String field195;
   @ObfuscatedName("x")
   Object[] field196;
   @ObfuscatedName("pg")
   static class116 field200;
   @ObfuscatedName("n")
   boolean field201;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "1952509476"
   )
   static final void method200(class159 var0, int var1) {
      int var2 = var0.offset;
      class45.field919 = 0;
      class39.method822(var0);

      for(int var3 = 0; var3 < class45.field919; ++var3) {
         int var4 = class45.field920[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 128) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         DecorativeObject.method2017(var0, var4, var5, var6);
      }

      if(var1 != var0.offset - var2) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(LActor;S)V",
      garbageValue = "1023"
   )
   static final void method201(Actor var0) {
      int var1 = var0.field644 - Client.gameCycle;
      int var2 = var0.field645 * 128 + var0.field607 * 64;
      int var3 = var0.field607 * 64 + var0.field647 * 128;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field661 = 0;
      var0.field654 = var0.field626;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1401439229"
   )
   public static int method202(int var0) {
      Varbit var1 = class30.method704(var0);
      int var2 = var1.leastSignificantBit;
      int var3 = var1.configId;
      int var4 = var1.mostSignificantBit;
      int var5 = class165.field2163[var4 - var3];
      return class165.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "-16"
   )
   static final void method203(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class45.method914(var2);
      }

      for(class133 var4 = (class133)Client.widgetFlags.method2440(); var4 != null; var4 = (class133)Client.widgetFlags.method2441()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var5 = ChatLineBuffer.method993(var3);
      if(var5 != null) {
         ChatLineBuffer.method996(var5);
      }

      class63.method1239();
      if(Client.widgetRoot != -1) {
         class104.method2090(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1351748135"
   )
   static final void method204(String var0) {
      if(null != var0) {
         String var1 = class60.method1229(var0, class149.field2037);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = class60.method1229(var4, class149.field2037);
               boolean var6;
               if(null != var0 && null != var4) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.friendCount;

                  for(int var7 = var2; var7 < Client.friendCount; ++var7) {
                     Client.friends[var7] = Client.friends[var7 + 1];
                  }

                  Client.field482 = Client.field505;
                  Client.field332.method3144(11);
                  Client.field332.method2873(class165.method3233(var0));
                  Client.field332.method2915(var0);
                  break;
               }
            }

         }
      }
   }
}
