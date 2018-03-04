import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public final class class61 {
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1604961709
   )
   static int field733;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BB)Lct;",
      garbageValue = "7"
   )
   @Export("newScript")
   static Script newScript(byte[] var0) {
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
         var1.switches = var1.method2045(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(var8 > 0?BoundingBox3DDrawMode.nextPowerOfTwo(var8):1);
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "996652480"
   )
   public static boolean method1024() {
      try {
         if(class229.field2694 == 2) {
            if(class5.field36 == null) {
               class5.field36 = Track1.getMusicFile(class229.field2687, class229.field2691, AttackOption.field1331);
               if(class5.field36 == null) {
                  return false;
               }
            }

            if(class185.field2500 == null) {
               class185.field2500 = new class110(class229.field2689, class229.field2693);
            }

            if(class229.field2690.method4317(class5.field36, class229.field2688, class185.field2500, 22050)) {
               class229.field2690.method4255();
               class229.field2690.method4305(class229.field2692);
               class229.field2690.method4258(class5.field36, class37.field506);
               class229.field2694 = 0;
               class5.field36 = null;
               class185.field2500 = null;
               class229.field2687 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class229.field2690.method4259();
         class229.field2694 = 0;
         class5.field36 = null;
         class185.field2500 = null;
         class229.field2687 = null;
      }

      return false;
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1717834786"
   )
   static final void method1016() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == class36.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1835(Client.field914);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  class86.region.method3026(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "260449837"
   )
   static void method1023(int var0, int var1) {
      PacketNode var2 = class31.method285(ClientPacket.field2402, Client.field899.field1470);
      var2.packetBuffer.putShort(var1);
      var2.packetBuffer.method3625(var0);
      Client.field899.method2082(var2);
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Liw;I)Ljava/lang/String;",
      garbageValue = "545750989"
   )
   static String method1022(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = ItemContainer.method1078(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }
}
