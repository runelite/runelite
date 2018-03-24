import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3364("runescape", "RuneScape", 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3361("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3360("game3", "Game 3", 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3365("game4", "Game 4", 3),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3362("game5", "Game 5", 4),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3363("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("e")
   @Export("name")
   public final String name;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1898258613
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1290719922"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(SoundTaskDataProvider.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            SoundTaskDataProvider.NetCache_socket.vmethod3340(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               SoundTaskDataProvider.NetCache_socket.vmethod3339();
            } catch (Exception var3) {
               ;
            }

            ++class264.field3413;
            SoundTaskDataProvider.NetCache_socket = null;
         }

      }
   }
}
