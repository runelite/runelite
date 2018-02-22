import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class170 extends class168 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   static IndexDataBase field2192;
   @ObfuscatedName("b")
   Socket field2191;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   class162 field2189;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   GameSocket field2193;

   public class170(Socket var1, int var2, int var3) throws IOException {
      this.field2191 = var1;
      this.field2191.setSoTimeout(30000);
      this.field2191.setTcpNoDelay(true);
      this.field2191.setReceiveBufferSize(65536);
      this.field2191.setSendBufferSize(65536);
      this.field2189 = new class162(this.field2191.getInputStream(), var2);
      this.field2193 = new GameSocket(this.field2191.getOutputStream(), var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-118954090"
   )
   public boolean vmethod3341(int var1) throws IOException {
      return this.field2189.method3194(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "26"
   )
   public int vmethod3346() throws IOException {
      return this.field2189.method3195();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1770569252"
   )
   public int vmethod3318() throws IOException {
      return this.field2189.method3219();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1399740149"
   )
   public int vmethod3321(byte[] var1, int var2, int var3) throws IOException {
      return this.field2189.method3196(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2027539026"
   )
   public void vmethod3323(byte[] var1, int var2, int var3) throws IOException {
      this.field2193.read(var1, var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   public void vmethod3317() {
      this.field2193.method3363();

      try {
         this.field2191.close();
      } catch (IOException var2) {
         ;
      }

      this.field2189.method3197();
   }

   protected void finalize() {
      this.vmethod3317();
   }
}
