import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class161 extends class159 {
   @ObfuscatedName("z")
   static int[] field2189;
   @ObfuscatedName("t")
   static int[][][] field2183;
   @ObfuscatedName("di")
   @Export("host")
   static String host;
   @ObfuscatedName("n")
   Socket field2184;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   class153 field2186;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   GameSocket field2188;

   class161(Socket var1, int var2, int var3) throws IOException {
      this.field2184 = var1;
      this.field2184.setSoTimeout(30000);
      this.field2184.setTcpNoDelay(true);
      this.field2184.setReceiveBufferSize(65536);
      this.field2184.setSendBufferSize(65536);
      this.field2186 = new class153(this.field2184.getInputStream(), var2);
      this.field2188 = new GameSocket(this.field2184.getOutputStream(), var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "677753628"
   )
   public boolean vmethod3153(int var1) throws IOException {
      return this.field2186.method3010(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2068163237"
   )
   public int vmethod3138() throws IOException {
      return this.field2186.method3024();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "267419020"
   )
   public int vmethod3167() throws IOException {
      return this.field2186.method3011();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-189738498"
   )
   public int vmethod3148(byte[] var1, int var2, int var3) throws IOException {
      return this.field2186.method3012(var1, var2, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-383534561"
   )
   public void vmethod3166(byte[] var1, int var2, int var3) throws IOException {
      this.field2188.read(var1, var2, var3);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   public void vmethod3136() {
      this.field2188.method3183();

      try {
         this.field2184.close();
      } catch (IOException var2) {
         ;
      }

      this.field2186.method3013();
   }

   protected void finalize() {
      this.vmethod3136();
   }
}
