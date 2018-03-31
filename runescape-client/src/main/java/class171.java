import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class171 extends class169 {
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -1238115095
   )
   static int field2225;
   @ObfuscatedName("c")
   Socket field2224;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   class163 field2223;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   GameSocket field2222;

   class171(Socket var1, int var2, int var3) throws IOException {
      this.field2224 = var1;
      this.field2224.setSoTimeout(30000);
      this.field2224.setTcpNoDelay(true);
      this.field2224.setReceiveBufferSize(65536);
      this.field2224.setSendBufferSize(65536);
      this.field2223 = new class163(this.field2224.getInputStream(), var2);
      this.field2222 = new GameSocket(this.field2224.getOutputStream(), var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-41"
   )
   public boolean vmethod3338(int var1) throws IOException {
      return this.field2223.method3207(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "8917861"
   )
   public int vmethod3316() throws IOException {
      return this.field2223.method3208();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1719250034"
   )
   public int vmethod3315() throws IOException {
      return this.field2223.method3211();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "903617518"
   )
   public int vmethod3318(byte[] var1, int var2, int var3) throws IOException {
      return this.field2223.method3210(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1130563356"
   )
   public void vmethod3320(byte[] var1, int var2, int var3) throws IOException {
      this.field2222.read(var1, var2, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1801563331"
   )
   public void vmethod3325() {
      this.field2222.method3353();

      try {
         this.field2224.close();
      } catch (IOException var2) {
         ;
      }

      this.field2223.method3222();
   }

   protected void finalize() {
      this.vmethod3325();
   }
}
