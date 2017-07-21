import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -337631725
   )
   static int field798;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -891262843
   )
   @Export("world")
   int world;
   @ObfuscatedName("g")
   boolean field802;
   @ObfuscatedName("m")
   boolean field803;
   @ObfuscatedName("c")
   @Export("name")
   String name;
   @ObfuscatedName("o")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 497209323
   )
   @Export("rank")
   int rank;

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "569794170"
   )
   static final boolean method1040(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1276252730"
   )
   static void method1039() {
      if(class92.field1414) {
         class92.field1396 = null;
         class92.field1397 = null;
         class36.field493 = null;
         class92.field1394 = null;
         class92.field1399 = null;
         class92.logoSprite = null;
         AbstractByteBuffer.titlemuteSprite = null;
         class177.field2382 = null;
         WorldMapType1.field413 = null;
         class23.field340 = null;
         class175.field2368 = null;
         WorldMapType2.field521 = null;
         class164.field2280 = null;
         WorldMapType2.field522 = null;
         class31.field431 = null;
         class92.field1405 = null;
         VertexNormal.field1970 = null;
         class67.field816 = null;
         class92.field1406 = null;
         class92.field1409 = null;
         class24.field348 = null;
         CombatInfo1.field1271 = null;
         class112.method2031(2);
         CombatInfoListHolder.sendConInfo(true);
         class92.field1414 = false;
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lho;I)Ljava/lang/String;",
      garbageValue = "-707344337"
   )
   static String method1038(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class175.method3312(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(WorldMapType3.field373 != null) {
               var7 = MouseInput.method973(WorldMapType3.field373.field2190);
               if(WorldMapType3.field373.value != null) {
                  var7 = (String)WorldMapType3.field373.value;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)Lcv;",
      garbageValue = "159430615"
   )
   static Script method1037(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1781(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(class43.method593(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }
}
