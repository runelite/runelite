import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class171 extends class169 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 870607291
   )
   public static int field2199;
   @ObfuscatedName("t")
   Socket field2197;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   class163 field2195;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   GameSocket field2198;

   public class171(Socket var1, int var2, int var3) throws IOException {
      this.field2197 = var1;
      this.field2197.setSoTimeout(30000);
      this.field2197.setTcpNoDelay(true);
      this.field2197.setReceiveBufferSize(65536);
      this.field2197.setSendBufferSize(65536);
      this.field2195 = new class163(this.field2197.getInputStream(), var2);
      this.field2198 = new GameSocket(this.field2197.getOutputStream(), var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean vmethod3337(int var1) throws IOException {
      return this.field2195.method3190(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1714062859"
   )
   public int vmethod3336() throws IOException {
      return this.field2195.method3191();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-79385341"
   )
   public int vmethod3335() throws IOException {
      return this.field2195.method3192();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1560304317"
   )
   public int vmethod3338(byte[] var1, int var2, int var3) throws IOException {
      return this.field2195.method3193(var1, var2, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-796507680"
   )
   public void vmethod3340(byte[] var1, int var2, int var3) throws IOException {
      this.field2198.read(var1, var2, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2082122029"
   )
   public void vmethod3339() {
      this.field2198.method3373();

      try {
         this.field2197.close();
      } catch (IOException var2) {
         ;
      }

      this.field2195.method3198();
   }

   protected void finalize() {
      this.vmethod3339();
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-124432457"
   )
   static void method3303() {
      if(WorldMapData.localPlayer.x >> 7 == Client.destinationX && WorldMapData.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

   }
}
