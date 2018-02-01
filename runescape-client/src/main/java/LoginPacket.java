import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("LoginPacket")
public class LoginPacket implements class169 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   public static final LoginPacket field2385;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   static final LoginPacket field2381;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   public static final LoginPacket field2380;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   public static final LoginPacket field2382;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lfu;"
   )
   static final LoginPacket[] field2384;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -117258555
   )
   @Export("id")
   public final int id;

   static {
      field2385 = new LoginPacket(14, 0);
      field2381 = new LoginPacket(15, 4);
      field2380 = new LoginPacket(16, -2);
      field2382 = new LoginPacket(18, -2);
      field2384 = new LoginPacket[32];
      LoginPacket[] var0 = new LoginPacket[]{field2380, field2381, field2382, field2385};
      LoginPacket[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         field2384[var1[var2].id] = var1[var2];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1317506746"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class222.varpsMasks[var5 - var4];
      return class222.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lbi;I)V",
      garbageValue = "-2135826363"
   )
   static void method3293(World var0) {
      if(var0.method1608() != Client.isMembers) {
         Client.isMembers = var0.method1608();
         class31.method288(var0.method1608());
      }

      FrameMap.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      MouseRecorder.port1 = Client.socketType == 0?43594:var0.id + 40000;
      BoundingBox3D.port2 = Client.socketType == 0?443:var0.id + 50000;
      ItemContainer.myWorldPort = MouseRecorder.port1;
   }
}
