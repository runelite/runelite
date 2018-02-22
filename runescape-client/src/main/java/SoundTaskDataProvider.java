import java.awt.Component;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements TaskDataProvider {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1987602879
   )
   static int field599;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ldw;",
      garbageValue = "212856446"
   )
   public AbstractSoundSystem taskData() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1976819622"
   )
   static void method800(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)V",
      garbageValue = "27"
   )
   static final void method799(String var0, int var1) {
      PacketNode var2 = class61.method1076(ClientPacket.field2353, Client.field863.field1434);
      var2.packetBuffer.putByte(class43.getLength(var0) + 1);
      var2.packetBuffer.method3574(var1);
      var2.packetBuffer.putString(var0);
      Client.field863.method2039(var2);
   }
}
