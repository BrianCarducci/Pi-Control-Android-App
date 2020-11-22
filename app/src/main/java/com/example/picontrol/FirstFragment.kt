package com.example.picontrol

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

import Commands
import java.nio.charset.Charset
import kotlin.reflect.typeOf

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
val deviceName = android.os.Build.MODEL.toByteArray();

class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.send_button).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//            send(cmd.ordinal, deviceName.length, deviceName)

            Log.d("device name", deviceName.toString(Charsets.UTF_8))
            val sent = makeMsg(Commands.PI_CTRL_SET_NAME.ordinal, deviceName.size, deviceName)
            Log.d("command",  sent[0].toInt().toString())
            Log.d("size",  sent[1].toInt().toString())
            val jeff = sent[1].toInt()
            Log.d("payload", (sent.sliceArray(IntRange(2, jeff + 1))).toString(Charsets.UTF_8))
        }
    }

    private fun makeMsg(cmd: Int, payloadSize: Int, payload: ByteArray): ByteArray {
//        return byteArrayOf(cmd.toByte(), payloadSize.toByte(), *payload)
        Log.d("payload size", payloadSize.toString())
        return byteArrayOf(cmd.toByte(), payloadSize.toByte()) + payload
    }
}