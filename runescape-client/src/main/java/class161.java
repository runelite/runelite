import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class161 extends class159 {
   @ObfuscatedName("p")
   Socket field2135;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   class153 field2138;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   GameSocket field2136;

   public class161(Socket var1, int var2, int var3) throws IOException {
      this.field2135 = var1;
      this.field2135.setSoTimeout(30000);
      this.field2135.setTcpNoDelay(true);
      this.field2135.setReceiveBufferSize(65536);
      this.field2135.setSendBufferSize(65536);
      this.field2138 = new class153(this.field2135.getInputStream(), var2);
      this.field2136 = new GameSocket(this.field2135.getOutputStream(), var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1280125978"
   )
   public boolean vmethod3220(int var1) throws IOException {
      return this.field2138.method3063(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-120"
   )
   public int vmethod3188() throws IOException {
      return this.field2138.method3064();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-693383529"
   )
   public int vmethod3215() throws IOException {
      return this.field2138.method3070();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-719042495"
   )
   public int vmethod3190(byte[] var1, int var2, int var3) throws IOException {
      return this.field2138.method3082(var1, var2, var3);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "44"
   )
   public void vmethod3192(byte[] var1, int var2, int var3) throws IOException {
      this.field2136.read(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-953149698"
   )
   public void vmethod3186() {
      this.field2136.method3242();

      try {
         this.field2135.close();
      } catch (IOException var2) {
         ;
      }

      this.field2138.method3067();
   }

   protected void finalize() {
      this.vmethod3186();
   }
}
