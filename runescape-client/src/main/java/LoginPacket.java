import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("LoginPacket")
public class LoginPacket implements class169 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final LoginPacket field2422;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   static final LoginPacket field2418;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final LoginPacket field2417;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final LoginPacket field2419;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfi;"
   )
   static final LoginPacket[] field2420;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -771004945
   )
   @Export("id")
   public final int id;

   static {
      field2422 = new LoginPacket(14, 0);
      field2418 = new LoginPacket(15, 4);
      field2417 = new LoginPacket(16, -2);
      field2419 = new LoginPacket(18, -2);
      field2420 = new LoginPacket[32];
      LoginPacket[] var0 = class70.method1113();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2420[var0[var1].id] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "45"
   )
   static final void method3410(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(ServerPacket.loadWidget(var0)) {
         GameCanvas.field628 = null;
         class2.gameDraw(ScriptState.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(GameCanvas.field628 != null) {
            class2.gameDraw(GameCanvas.field628, -1412584499, var1, var2, var3, var4, InvType.field3363, WorldComparator.field268, var7);
            GameCanvas.field628 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1029[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1029[var8] = true;
            }
         }

      }
   }
}
