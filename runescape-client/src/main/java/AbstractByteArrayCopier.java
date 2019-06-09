import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
   @ObfuscatedName("f")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("__gu_et")
   static IndexCache __gu_et;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1219910462"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2034091753"
   )
   @Export("set")
   abstract void set(byte[] var1);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "1102198559"
   )
   public static VarcInt method4021(int var0) {
      VarcInt var1 = (VarcInt)VarcInt.__iw_f.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarcInt.__iw_m.takeRecord(19, var0);
         var1 = new VarcInt();
         if(var2 != null) {
            var1.__q_411(new Buffer(var2));
         }

         VarcInt.__iw_f.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1941491045"
   )
   public static void method4023(int var0) {
      if(var0 != -1) {
         if(Widget.loadedWidgetGroups[var0]) {
            Widget.Widget_indexCache.__h_399(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Widget.loadedWidgetGroups[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1256278627"
   )
   static void method4024() {
      PacketBufferNode var0 = Interpreter.method1915(ClientPacket.__gs_aw, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(SpotAnimationDefinition.method4822());
      var0.packetBuffer.writeShort(SoundCache.canvasWidth);
      var0.packetBuffer.writeShort(Huffman.canvasHeight);
      Client.packetWriter.__q_167(var0);
   }
}
